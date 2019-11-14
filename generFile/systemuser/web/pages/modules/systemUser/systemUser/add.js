var systemUserAddForm = function($){
	var _that = null;
	return {
		init:function(){
			_that = this;
			_that.bindEvent();
			_that.bindData();
			_that.bindComponent();
		},
		bindEvent:function(){
			_that.formSubmit();
		},
		bindData:function(){
			
		},
		bindComponent:function(){
			
		},
		formSubmit:function(){
			$("#inputForm").validate({
				submitHandler: function(form){
					js.ajaxSubmitForm($(form), function(data){
						js.showMessage(data.message);
						if(data.success){
							js.closeCurrentTabPage(function(contentWindow){
								contentWindow.page();
							});
						} 
					}, "json");
				}
			});
		}
	}
}(jQuery);
