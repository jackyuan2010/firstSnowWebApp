var app = app || {};
(function($) {

	function ContactDaoHandler(entityName){
		ContactDaoHandler._super.constructor.call(this,entityName);
	}
	brite.inherit(ContactDaoHandler,RemoteDaoHandler);

	ContactDaoHandler.prototype.createContact = function(props){
		var data = {};
		data.props = JSON.stringify(props);
		return app.doPost(this._opts.contextPath + "contact/createContact", data);
	};

	ContactDaoHandler.prototype.getContactsByGroupId = function(groupId){
		return app.doGet(this._opts.contextPath + "contact/getContactsByGroupId?groupId=" + groupId);
	};

	app.ContactDaoHandler =  ContactDaoHandler;
})(jQuery);