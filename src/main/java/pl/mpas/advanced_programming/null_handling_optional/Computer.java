package pl.mpas.advanced_programming.null_handling_optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Computer {

    private GraphicsCard graphicsCard;

    public Computer(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public Optional<GraphicsCard> getGraphicsCard() {
        return Optional.ofNullable(graphicsCard);
    }

    @Override
    public String toString() {
        return "ComputerOpt{" +
                "graphicsCard=" + graphicsCard +
                '}';
    }

}
