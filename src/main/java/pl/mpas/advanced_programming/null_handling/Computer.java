package pl.mpas.advanced_programming.null_handling;

import java.util.Optional;

public class Computer {

    private GraphicsCard graphicsCard;

    public Computer(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    @Override
    public String toString() {
        return "ComputerOpt{" +
                "graphicsCard=" + graphicsCard +
                '}';
    }

}
