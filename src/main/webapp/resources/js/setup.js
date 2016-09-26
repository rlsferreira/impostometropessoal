(function ($) {
  $('.spinner .btn:first-of-type').on('click', function() {
    $('.spinner input').val( parseInt($('.spinner input').val(), 10) + 1);
  });
  $('.spinner .btn:last-of-type').on('click', function() {
    $('.spinner input').val( parseInt($('.spinner input').val(), 10) - 1);
  });
})(jQuery);

/*$(document).ready(function(){
	$('.priceFormat').each(function( index ) {
		$(this).priceFormat({
		    prefix: 'R$',
		    centsSeparator: ',',
		    thousandsSeparator: '.',
		    limit: 7,
		    centsLimit: 2
		});
	});
});*/