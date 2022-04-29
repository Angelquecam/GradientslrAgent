import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Gradientagent extends Agent {

    protected void setup() {
        Guis myGui = new Guis(this);
        myGui.showGui();
        System.out.println("Agente iniciando");
        System.out.println("My local name is " + getAID().getLocalName());

    }

    public void obtenerX(final String x) {
        addBehaviour(new Behaviour() {
            boolean end = false;

            public void action() {
                Dataset data = new Dataset();
                Gradient Gradin = new Gradient(data.getX(), data.getY());
                System.out.println("Ecuacion de regresion lineal: Y = " + Gradin.getB0() + " +( "
                        + Gradin.getB1() + " * " + x + ")");
                System.out.print("Valor proyectado de Y: ");
                System.out.print(Gradin.getB0() + Gradin.getB1() * Double.parseDouble(x) + "\n");
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
