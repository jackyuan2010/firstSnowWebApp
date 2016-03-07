var app = app || {};
(function($) {

	function GroupDaoHandler(entityName){
		GroupDaoHandler._super.constructor.call(this,entityName);
	}
	brite.inherit(GroupDaoHandler,RemoteDaoHandler);

	GroupDaoHandler.prototype.createGroup = function(props){
		var data = {};
		data.props = JSON.stringify(props);
		return app.doPost(this._opts.contextPath + "group/createGroup", data);
	};

	GroupDaoHandler.prototype.getGroups = function(){
		var params = {};
		return app.doGet(this._opts.contextPath + "group/getGroups", params);
	};

	GroupDaoHandler.prototype.getGroupByName = function(opts){
		var params = opts || {};
		return app.doGet(this._opts.contextPath + "group/getGroupByName", params);
	};

	app.GroupDaoHandler =  GroupDaoHandler;
})(jQuery);