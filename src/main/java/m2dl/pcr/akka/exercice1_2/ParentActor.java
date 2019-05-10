package m2dl.pcr.akka.exercice1_2;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Procedure;

public class ParentActor extends UntypedActor {

    private ActorRef helloChildRef;
    private ActorRef goodbyeChildRef;
    Procedure<Object> goodbye = new Procedure<Object>() {
        public void apply(Object msg) throws Exception {
            if (msg instanceof String) {
                goodbyeChildRef.tell(msg, getSelf());
                getContext().unbecome();
            } else {
                unhandled(msg);
            }
        }
    };
    Procedure<Object> hello = new Procedure<Object>() {
        public void apply(Object msg) throws Exception {
            if (msg instanceof String) {
                helloChildRef.tell(msg, getSelf());
                getContext().become(goodbye, false);
            } else {
                unhandled(msg);
            }
        }
    };

    public ParentActor() {
        helloChildRef = getContext().actorOf(Props.create(HelloActor.class), "hello-actor");
        goodbyeChildRef = getContext().actorOf(Props.create(GoodbyActor.class), "goodby-actor");
    }

    public void onReceive(Object o) throws Exception {
        hello.apply(o);
    }
}
