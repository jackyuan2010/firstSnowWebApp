DROP DATABASE IF EXISTS firstsnowwebapp_db;
DROP USER IF EXISTS firstsnowwebapp_user;
CREATE USER firstsnowwebapp_user PASSWORD 'welcome';
CREATE DATABASE firstsnowwebapp_db owner firstsnowwebapp_user ENCODING = 'UTF-8';


