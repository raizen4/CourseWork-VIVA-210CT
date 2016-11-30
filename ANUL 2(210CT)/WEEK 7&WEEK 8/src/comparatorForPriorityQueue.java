import java.util.Comparator;



public class comparatorForPriorityQueue implements Comparator<WeightedGraph.Node> {

	@Override
	public int compare(WeightedGraph.Node firstNode, WeightedGraph.Node secondNode) {
		if(firstNode.data>secondNode.data)
			return 1;
		else if(firstNode.data<secondNode.data)
			return -1;
		else if(firstNode.data==secondNode.data)
			return 0;
		// TODO Auto-generated method stub
		return 0;
	}

}
