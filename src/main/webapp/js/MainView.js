(function(){

	brite.registerView("MainView",{parent:"body", emptyParent:true}, {
		create: function(){
			return render("MainView");
		},

		init: function(){
			var view = this;
			return brite.display("GroupListView",view.$el.find(".MainView-leftPanel")).whenInit;
		},

		postDisplay: function(){
			app.fetchUser();
		},

		events: {
			"click; .do-logoff": function(){
				app.doGet("/logoff").done(function(){
					window.location.reload();
				});
			},

			"DO_REFRESHCONTACTS": function(){
			    var view = this;
			    var contactView = view.$el.find(".MainView-contentPanel");
			    contactView.bEmpty();
			    brite.display("ContactView",contactView, view.currentGroupId);
			},
		},

		docEvents: {
		    "APP_CTX_CHANGE": function(event){
		        var view = this;
		        if ("group" === app.ctx.pathAt(0) && $.isNumeric(app.ctx.pathAt(1))){
		            var newGroupId = app.ctx.pathAt(1) * 1;
		            if (newGroupId !== view.currentGroupId){
		                var contactView = view.$el.find(".MainView-contentPanel");
		                contactView.bEmpty();
		                brite.display("ContactView",contactView, newGroupId);
		                view.currentGroupId = newGroupId;
		            }
		        }
		    }
		},
	});
})();
