import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GradSLR extends Agent {

    protected void setup() {
        Gui myGui = new Gui(this);
        myGui.showGui();
        System.out.println("Agente iniciando");
        System.out.println("My local name is " + getAID().getLocalName());

    }

    public void obtenerX(final String val) {
        addBehaviour(new Behaviour() {
            boolean end = false;

            public void action() {
                Dataset data = new Dataset();
                data.tables();
                OpGradiente gradin = new OpGradiente(data.getX(), data.getY(),Double.parseDouble(val));
                end = true;
            }

            @Override
            public boolean done() {
                if (end == true) {
                    return true;
                } else {
                    return false;
                }
            }

            public int onEnd() {
                System.out.println("-Agente muriendo-");
                myAgent.doDelete();
                return super.onEnd();
            }

        });
    }
}
