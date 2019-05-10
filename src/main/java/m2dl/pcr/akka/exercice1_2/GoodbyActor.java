package m2dl.pcr.akka.exercice1_2;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class GoodbyActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public void onReceive(Object o) throws Exception {
        if (o instanceof String) {
            log.info("Goodbye " + o);
        } else {
            unhandled(o);
        }
    }
}
