package com.wildcodeschool.submarine.springHibernateSubmarine.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.submarine.springHibernateSubmarine.entities.Submarine;
import com.wildcodeschool.submarine.springHibernateSubmarine.repositories.SubmarineDao;

@Component
public class SubmarineOutputter implements CommandLineRunner {

    private Logger       LOG = LoggerFactory.getLogger( "wilder" );

    @Autowired
    private SubmarineDao submarineDao;

    @Override
    public void run( String... args ) throws Exception {

        // Check combien de sous-marins se trouvent dans la BDD
        LOG.info( "******************" );
        LOG.info( "Submarine in DB : " + submarineDao.count() );

        // Crée un nouveau sous-marin et l'enregistrer dans la BDD
        Submarine sm1 = new Submarine( "Le Terrible", "Le Triomphant" );
        LOG.info( "******************" );
        LOG.info( sm1 + " has been created !" );
        submarineDao.save( sm1 );
        LOG.info( sm1 + " has been saved !" );

        // Crée un second sous-marin et l'enregistrer dans la BDD
        Submarine sm2 = new Submarine( "Le Foudroyant", "alpha" );
        LOG.info( "******************" );
        LOG.info( sm2 + " has been created !" );
        sm2.setType( "Le Redoutable" );
        submarineDao.save( sm2 );
        LOG.info( sm2 + " has been saved !" );

        // Lit les informations correspondant au second sous-marin
        Submarine tempSubmarine = submarineDao.findById( 2L ).get();
        LOG.info( "******************" );
        LOG.info( "Second submarine name is " + "\"" + tempSubmarine.getName() + "\"" );
        LOG.info( "Second submarine class is " + "\"" + tempSubmarine.getType() + "\"" );

        // Liste les sous-marins enregistrés dans la BDD
        LOG.info( "******************" );
        LOG.info( "Submarines in list are " );
        for ( Submarine mySubmarine : submarineDao.findAll() ) {
            LOG.info( mySubmarine.toString() );
        }

        // Supprime le second sous-marin de la BDD
        submarineDao.deleteById( 2L );
        /*
         * Liste les sous-marins enregistrés dans la BDD (permet de vérifier que
         * le second utilisateur a bien été supprimé de la BDD)
         */
        LOG.info( "******************" );
        LOG.info( "subMarines in list are " );
        for ( Submarine mySubmarine : submarineDao.findAll() ) {
            LOG.info( mySubmarine.toString() );

        }

    }
}
