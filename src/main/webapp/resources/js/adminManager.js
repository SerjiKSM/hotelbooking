
var jsonConfig;

adminManager = {

    init: function (configData) {
        jsonConfig = configData;

        $('#additionalApartmentService').on('change', this.additionalApartmentService);
        $('.booking').on('click', this.checkDateReservation);

        $('#dateFromBooking').on('change', this.dateFromBooking);
        $('#dateToBooking').on('change', this.dateToBooking);

    },
    dateFromBooking: function () {
        if (adminManager.checkDateFromBooking()) {
            adminManager.getTotal();
        }
    },
    dateToBooking: function () {
        if (adminManager.checkDateToBooking()) {
            adminManager.getTotal();
        }
    },
    checkDateFromBooking: function () {
        var dateFromBooking = $('#dateFromBooking').val();
        var dateToBooking = $('#dateToBooking').val();
        var oldDateFromBooking = $('#oldDateFromBooking').val();
        var oldDateToBooking = $('#oldDateToBooking').val();

        if( (new Date(dateFromBooking).getTime() < new Date(oldDateFromBooking).getTime())) {
            alert("Date-from can not be less than " + oldDateFromBooking);
            $('#dateFromBooking').val($('#oldDateFromBooking').val());
            adminManager.getTotal();
            return false;
        }

        if( (new Date(dateFromBooking).getTime() >= new Date(dateToBooking).getTime())) {
            alert("Date-from can not be more than or equal " + dateToBooking);
            $('#dateFromBooking').val($('#oldDateFromBooking').val());
            adminManager.getTotal();
            return false;
        }

        if( (new Date(dateFromBooking).getTime() >= new Date(oldDateToBooking).getTime())) {
            alert("Date-from can not be more than or equal " + oldDateToBooking);
            adminManager.getTotal();
            $('#dateFromBooking').val($('#oldDateFromBooking').val());
            return false;
        }
        return true;

    },
    checkDateToBooking: function () {
        var dateFromBooking = $('#dateFromBooking').val();
        var dateToBooking = $('#dateToBooking').val();
        var oldDateFromBooking = $('#oldDateFromBooking').val();
        var oldDateToBooking = $('#oldDateToBooking').val();

        if( (new Date(dateToBooking).getTime() > new Date(oldDateToBooking).getTime())) {
            alert("Date-to can not be more than " + oldDateToBooking);
            $('#dateToBooking').val($('#oldDateToBooking').val());
            adminManager.getTotal();
            return false;
        }

        if( (new Date(dateToBooking).getTime() <= new Date(dateFromBooking).getTime())) {
            alert("Date-to can not be less or equal than " + dateFromBooking);
            $('#dateToBooking').val($('#oldDateToBooking').val());
            adminManager.getTotal();
            return false;
        }

        if( (new Date(dateToBooking).getTime() <= new Date(oldDateFromBooking).getTime())) {
            alert("Date-to can not be less or equal than " + oldDateFromBooking);
            $('#dateToBooking').val($('#oldDateToBooking').val());
            adminManager.getTotal();
            return false;
        }
        return true;
    },
    getTotal: function () {
        var apartmentPrice = Number($('#apartmentPrice').val());
        var additionalApartmentServicePrice = Number($('#additionalApartmentServicePrice').val());
        var dateFrom = $('#dateFromBooking').val();
        var dateTo = $('#dateToBooking').val();

        var a = moment(dateFrom, 'YYYY-MM-DD');
        var b = moment(dateTo, 'YYYY-MM-DD');
        var daysBetweenDates = b.diff(a, 'days');

        var totalSum = (apartmentPrice + additionalApartmentServicePrice) * daysBetweenDates;
        $('#total').val(totalSum.toFixed(1));
    },
    checkDateReservation: function () {
        var dateFrom = $('#dateFrom').val();
        var dateTo = $('#dateTo').val();
        if( (new Date(dateFrom).getTime() > new Date(dateTo).getTime())) {
            alert("Date-from can not be more than date-to!");
            return false;
        }
    },
    additionalApartmentService: function () {
        adminManager.findAdditionalApartmentServicePrice();
    },
    findAdditionalApartmentServicePrice: function() {
        var id = $( "select[ name = additionalApartmentService ] option:selected" ).val();
        var url = jsonConfig.urlFindAdditionalApartmentServicePrice;
        $.ajax({
            url: url,
            data: {id: id},
            dataType: 'json',
            type: 'POST',
            success: function(data){
                var apartmentPrice = Number($('#apartmentPrice').val());
                var additionalApartmentServicePrice = data.additionalApartmentServicePrice;
                var dateFrom = $('#dateFromBooking').val();
                var dateTo = $('#dateToBooking').val();

                var a = moment(dateFrom, 'YYYY-MM-DD');
                var b = moment(dateTo, 'YYYY-MM-DD');
                var daysBetweenDates = b.diff(a, 'days');

                if (additionalApartmentServicePrice == null) {
                    $('#additionalApartmentServicePrice').val("");
                    $('#total').val(apartmentPrice.toFixed(1) * daysBetweenDates);
                } else {
                    if (daysBetweenDates != null) {
                        var totalSum = (apartmentPrice + additionalApartmentServicePrice) * daysBetweenDates;
                    } else {
                        var totalSum = apartmentPrice + additionalApartmentServicePrice;
                    }
                    $('#additionalApartmentServicePrice').val(additionalApartmentServicePrice.toFixed(1));
                    $('#total').val(totalSum.toFixed(1));
                }
            },
            error: function(){
                alert('Error while request..');
            }
        });
    }
}
