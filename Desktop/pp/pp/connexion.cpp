#include "connexion.h"
#include "QSqlDatabase"
connexion::connexion()
{

}
bool connexion::createconnexion(){
    bool test=false;
    QSqlDatabase db = QSqlDatabase::addDatabase("QODBC");
    db.setDatabaseName("Projet_2A");
    db.setUserName("malek");
    db.setPassword("user");


    if(db.open())
        test=true;
    return(test);
}
