$(document).ready(function() {
    $('#contact-form').submit(function(e) {
      e.preventDefault();
      $('#contact-form').hide();
      $('#success-message').show();
    });
  });
