package hr.fer.zemris.optjava.dz12.node.function;

import hr.fer.zemris.optjava.dz12.AntTrailGA;
import hr.fer.zemris.optjava.dz12.Map;
import hr.fer.zemris.optjava.dz12.node.Node;
import hr.fer.zemris.optjava.dz12.node.terminal.TerminalNode;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.List;

/**
 * @author Kristijan Vulinovic
 * @version 1.0.0
 */
public class Prog2 extends FunctionNode {
    @Override
    public int getChildCount() {
        return 2;
    }

    @Override
    public int action(Map map, int count) {
        count = children.get(0).action(map, count);
        return children.get(1).action(map, count);
    }

    @Override
    public List<TerminalNode> getActions(Map map) {
        List<TerminalNode> nodes = children.get(0).getActions(map);
        nodes.addAll(children.get(1).getActions(map));

        if (nodes.size() > AntTrailGA.MAX_MOVES) {
            nodes = nodes.subList(0, AntTrailGA.MAX_MOVES);
        }
        return nodes;
    }

    @Override
    public Node copy() {
        FunctionNode newNode = new Prog2();
        newNode.addChild(this.getChild(0).copy());
        newNode.addChild(this.getChild(1).copy());

        return newNode;
    }

    @Override
    protected String getName() {
        return "Prog2";
    }
}
