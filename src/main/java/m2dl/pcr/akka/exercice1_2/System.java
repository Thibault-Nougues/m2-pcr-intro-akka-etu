package m2dl.pcr.akka.exercice1_2;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Main runtime class.
 */
public class System {

    public static final Logger log = LoggerFactory.getLogger(System.class);

    public static void main(String... args) throws Exception {

        final ActorSystem actorSystem = ActorSystem.create("actor-system");

        Thread.sleep(5000);

        final ActorRef actorRef = actorSystem.actorOf(Props.create(ParentActor.class), "parent-actor");

        actorRef.tell("John", actorRef);
        actorRef.tell("Pauline", actorRef);
        actorRef.tell("Eva", actorRef);
        actorRef.tell("Bill", actorRef);
        actorRef.tell("Marc", actorRef);

        Thread.sleep(1000);

        log.debug("Actor System Shutdown Starting...");

        actorSystem.terminate();
    }
}
