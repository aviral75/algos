package self.aviral.datastructures.graphs;

import java.util.List;

public class DeadLockDetection {
	
	private static class GraphVertex{
		public enum State { START,VISITING,VISITED};
		public State state;
		public List<GraphVertex> edges;
	}

	
	public static boolean isDeadlocked(List<GraphVertex> graph){
		return graph.stream().anyMatch(v->v.state==GraphVertex.State.START && hasCycle(v));
	}


	private static boolean hasCycle(GraphVertex v) {
		if(v.state==GraphVertex.State.VISITING){
			return true;
		}
		
		v.state=GraphVertex.State.VISITING;
		
		if(v.edges.stream().anyMatch(n->n.state!=GraphVertex.State.VISITED && hasCycle(n)))
			return true;
		
		v.state=GraphVertex.State.VISITED;
		return false;
	}
	
	public static void main(String[] args) {
	}
}

