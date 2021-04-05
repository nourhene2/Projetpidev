#include "connection.h"


#include "QSqlDatabase"
Connection::Connection()
{

}

bool Connection::createconnection()
{bool test=false;
QSqlDatabase db = QSqlDatabase::addDatabase("QODBC");
db.setDatabaseName("projet_2A");//inserer le nom de la source de données ODBC
db.setUserName("malek");//inserer nom de l'utilisateur
db.setPassword("user");//inserer mot de passe de cet utilisateur

//qDebug () <<" ODBC driver valid? "<< db.isValid ();

if (db.open())

{    test=true;
}
    return test;
}
