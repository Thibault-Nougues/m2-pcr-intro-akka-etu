package m2dl.pcr.akka.exercice1_2;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class HelloActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public void onReceive(Object o) throws Exception {
        if (o instanceof String) {
            log.info("Hello " + o);
        } else {
            unhandled(o);
        }
    }
}
