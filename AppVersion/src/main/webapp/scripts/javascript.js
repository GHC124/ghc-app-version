$(function(){    
	$.fn.styleTable = function (options) {
        var defaults = {
                css: 'ui-styled-table'
            };
        options = $.extend(defaults, options);

        return this.each(function () {
            $this = $(this);
            $this.addClass(options.css);

            $this.on('mouseover mouseout', 'tbody tr', function (event) {
                $(this).children().toggleClass("ui-state-hover",
                                               event.type == 'mouseover');
            });

            $this.find("th").addClass("ui-state-default");
            $this.find("td").addClass("ui-widget-content");
            $this.find("tr:last-child").addClass("last-child");
        });
    };
 	$("button").button();	
 	$('input').addClass("ui-corner-all");
});

function collectFormData(fields) {
	var data = {};
	for (var i = 0; i < fields.length; i++) {
		var $item = $(fields[i]);
		data[$item.attr('name')] = $item.val(); 
	}
	return data;
}
	
function resetFormData(formName){
	var $form = $(formName);	
	$form.find('.control-label').removeClass('error');
	$form.find('.help-inline').removeClass('error');
	$form.find('.help-inline').empty();
	$form.find('.alert').remove();		
}

function formAjaxSubmit(formName, validateUrl, successMethod, failMethod){
	var $form = $(formName);
	var $inputs = $form.find('input');
	var data = collectFormData($inputs);				
	$.post(validateUrl, data, function(response) {
		$form.find('.control-label').removeClass('error');
		$form.find('.help-inline').removeClass('error');
		$form.find('.help-inline').empty();
		$form.find('.alert').remove();					
		if (response.status == 'FAIL') {
			for (var i = 0; i < response.result.length; i++) {
				var item = response.result[i];
				var $controlGroup = $('#' + item.fieldName);
				$controlGroup.find('.control-label').addClass('error');
				$controlGroup.find('.help-inline').addClass('error');
				$controlGroup.find('.help-inline').append("<br/>"+item.message);				
			}
			failMethod(response);
		} else {
			successMethod();
		}
	}, 'json');
}

function refreshJQGrid(listId){
	$(listId).setGridParam({ page: 1, datatype: "json" }).trigger('reloadGrid');
}