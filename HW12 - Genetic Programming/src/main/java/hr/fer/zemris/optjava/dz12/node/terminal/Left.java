package hr.fer.zemris.optjava.dz12.node.terminal;

import hr.fer.zemris.optjava.dz12.AntTrailGA;
import hr.fer.zemris.optjava.dz12.Map;
import hr.fer.zemris.optjava.dz12.Orientation;
import hr.fer.zemris.optjava.dz12.node.Node;
import hr.fer.zemris.optjava.dz12.node.function.FunctionNode;
import hr.fer.zemris.optjava.dz12.node.function.Prog3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristijan Vulinovic
 * @version 1.0.0
 */
public class Left extends TerminalNode {

    @Override
    public int action(Map map, int count) {
        if (count >= AntTrailGA.MAX_MOVES){
            return count;
        }
        switch (map.getOrientation()){
            case LEFT:
                map.setOrientation(Orientation.DOWN);
                break;
            case DOWN:
                map.setOrientation(Orientation.RIGHT);
                break;
            case RIGHT:
                map.setOrientation(Orientation.UP);
                break;
            case UP:
                map.setOrientation(Orientation.LEFT);
                break;
        }
        return count + 1;
    }



    @Override
    public List<TerminalNode> getActions(Map map) {
        action(map, 0);

        List<TerminalNode> nodes = new ArrayList<>();

        nodes.add((TerminalNode)this.copy());
        return nodes;
    }

    @Override
    public Node copy() {
        return new Left();
    }

    @Override
    protected String getName() {
        return "Left";
    }
}
