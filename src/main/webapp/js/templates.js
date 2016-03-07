Handlebars.templates['ContactView']  = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "    <li class=\"group\" data-entity=\"Group\" data-entity-id=\""
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "\">\r\n        <a href=\"#group/"
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "\"\">"
    + alias4(((helper = (helper = helpers.groupName || (depth0 != null ? depth0.groupName : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"groupName","hash":{},"data":data}) : helper)))
    + "</a>\r\n    </li>\r\n";
},"3":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "            <tr data-entity-id=\""
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "\">\r\n                <td><input data-prop=\"contactName\" value=\""
    + alias4(((helper = (helper = helpers.contactName || (depth0 != null ? depth0.contactName : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"contactName","hash":{},"data":data}) : helper)))
    + "\"/></td>\r\n                <td><input data-prop=\"phoneNO\" value=\""
    + alias4(((helper = (helper = helpers.phoneNO || (depth0 != null ? depth0.phoneNO : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"phoneNO","hash":{},"data":data}) : helper)))
    + "\"/></td>\r\n                <td><input data-prop=\"officePhone\" value=\""
    + alias4(((helper = (helper = helpers.officePhone || (depth0 != null ? depth0.officePhone : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"officePhone","hash":{},"data":data}) : helper)))
    + "\"/></td>\r\n                <td><input data-prop=\"familyPhone\" value=\""
    + alias4(((helper = (helper = helpers.familyPhone || (depth0 != null ? depth0.familyPhone : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"familyPhone","hash":{},"data":data}) : helper)))
    + "\"/></td>\r\n                <td><input data-prop=\"contactAdd\" value=\""
    + alias4(((helper = (helper = helpers.contactAdd || (depth0 != null ? depth0.contactAdd : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"contactAdd","hash":{},"data":data}) : helper)))
    + "\"/></td>\r\n            </tr>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, alias1=depth0 != null ? depth0 : {};

  return "<div class=\"ContactView\">\r\n    <div class=\"contacts-Header\"><h2>Contacts</h2></div>\r\n    <ul>\r\n"
    + ((stack1 = helpers.each.call(alias1,(depth0 != null ? depth0.groups : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "    </ul>\r\n    <table class=\"contactTable\">\r\n        <tbody>\r\n            <tr>\r\n                <th>Contact Name</th>\r\n                <th>Phone</th>\r\n                <th>OfficePhone</th>\r\n                <th>FamilyPhone</th>\r\n                <th>Address</th>\r\n            </tr>\r\n"
    + ((stack1 = helpers.each.call(alias1,(depth0 != null ? depth0.contacts : depth0),{"name":"each","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            <tr data-entity-id=\"0\">\r\n                <td><input data-prop=\"contactName\" placeholder=\"New Contact\" type=\"input\"/></td>\r\n                <td><input data-prop=\"phoneNO\" type=\"input\" id=\"phoneNO\"/></td>\r\n                <td><input data-prop=\"officePhone\" type=\"input\"/></td>\r\n                <td><input data-prop=\"familyPhone\" type=\"input\"/></td>\r\n                <td><input data-prop=\"contactAdd\" type=\"input\"/></td>\r\n                <td>\r\n                    <ul>\r\n                        <li><a class=\"save-ico\">save</a></li>\r\n                        <li><a class=\"del-ico\">del</a></li>\r\n                    </ul>\r\n                </td>\r\n            </tr>\r\n        </tbody>\r\n    </table>\r\n</div>";
},"useData":true});


Handlebars.templates['GroupListView']  = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<div class=\"GroupListView\">\r\n    <h2>Groups</h2>\r\n    <ul>\r\n"
    + ((stack1 = container.invokePartial(partials["GroupListView-list"],depth0,{"name":"GroupListView-list","data":data,"indent":"    ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </ul>\r\n    <div class=\"add-new-group\">\r\n        <a class=\"action\">Add New Group</a>\r\n        <input type=\"text\" class=\"form-control\">\r\n    </div>\r\n</div>";
},"usePartial":true,"useData":true});

Handlebars.templates['GroupListView-list']  = Handlebars.template({"1":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "    <li class=\"group\" data-entity=\"Group\" data-entity-id=\""
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "\">\r\n        <a href=\"#group/"
    + alias4(((helper = (helper = helpers.id || (depth0 != null ? depth0.id : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"id","hash":{},"data":data}) : helper)))
    + "\"\">"
    + alias4(((helper = (helper = helpers.groupName || (depth0 != null ? depth0.groupName : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"groupName","hash":{},"data":data}) : helper)))
    + "</a>\r\n    </li>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.groups : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "");
},"useData":true});


Handlebars.templates['MainView']  = Handlebars.template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<div class=\"MainView\">\r\n    <div class=\"MainView-navbar\">\r\n      <img class=\"app-icon\" src=\"css/images/logo-24.png\" />\r\n      <h2>Address Book</h2>\r\n      <a href=\"#\" class=\"do-logoff navbar-right\">Logoff</a>\r\n    </div>\r\n\r\n	<section class=\"MainView-content\">\r\n		<div class=\"MainView-leftPanel\"></div>\r\n		<div class=\"MainView-contentPanel\"></div>\r\n	</section>\r\n</div>";
},"useData":true});

