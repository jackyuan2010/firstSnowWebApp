### Pre-requisite

1. Install Java 8

2. Install maven

3. Postgres 9.3+ in localhost port 5432 (default dev configuration in the /WEB-INF/snow.properties)

4. Install node.js/npm ([node.js install/download](https://nodejs.org/en/download/))
    - On mac, you can [intall node with brew](http://blog.teamtreehouse.com/install-node-js-npm-mac)
    - __IMPORTANT:__ Make sure you do not have a folder ```~/node_modules/``` otherwise local packages will be installed there which is not what we want. If you have such folder, delete it (then, local modules will be install per project folder).

5. Upgrade npm with: 

    npm -v
    sudo npm install npm -g

6. Upgrade node with (this way might not work on windows, google the correct way to update node to the latest): 

    # Clear NPM's cache:
    sudo npm cache clean -f 
    # Install a little helper called 'n'
    sudo npm install -g n   
    # Update node to the latest stable
    sudo n stable

7. Install gulp. 

    npm install gulp -g

    - Make sure to install gulp globally first (with -g) to have access to the "gulp" command.

    - _We are using maven to build, but we also call node.js from maven for all of the web files processing and other scripting needed (e.g., recreateDb from .sql file name conventions)_

8. Check node and npm version 

    npm -v

    Should be above 2.14.1

    node -v 
	
	Should be above v0.12.7

### Dev Setup

Once java 8, postgresql, maven, git, npm/node, and gulp are installed do the following steps:

1. Create a folder "firstSnowWebApp/" in your projects directory.

2. Clone maven source

    git clone git@github.com:jackyuan2010/firstSnowWebApp.git

3. install the node_modules for this project.

    npm install
 
4. Create the database

    $ gulp recreateDb

5. Initial build

    $ mvn clean package

6. From same command line, run maven jetty

    mvn jetty:run

7. When in development, automatically reprocess the web files when edit with

    gulp watch

8. Go to [http://localhost:8080/](http://localhost:8080/)
