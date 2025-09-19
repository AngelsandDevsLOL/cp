package CCC.Senior;

import java.util.*;

public class DegreeOfSeparation {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<Integer>[] ar = new ArrayList[51];
        for (int i = 0; i < 51; i++) {
            ar[i] = new ArrayList();
        }
        ar[1].add(6); ar[6].add(1); ar[2].add(6); ar[6].add(2);
        ar[3].add(6); ar[6].add(3); ar[7].add(6); ar[6].add(7);
        ar[4].add(6); ar[6].add(4); ar[5].add(6); ar[6].add(5);
        ar[4].add(3); ar[3].add(4); ar[5].add(4); ar[4].add(5);
        ar[5].add(3); ar[3].add(5); ar[3].add(15); ar[15].add(3);
        ar[7].add(8); ar[8].add(7); ar[8].add(9); ar[9].add(8);
        ar[10].add(9); ar[9].add(10); ar[10].add(11); ar[11].add(10);
        ar[11].add(12); ar[12].add(11); ar[13].add(12); ar[12].add(13);
        ar[13].add(15); ar[15].add(13); ar[13].add(14); ar[14].add(13);
        ar[16].add(17); ar[17].add(16); ar[17].add(18); ar[18].add(17);
        ar[16].add(18); ar[18].add(16); ar[12].add(9); ar[9].add(12);
        while (!input.equals("q")) {
            if (input.equals("i")) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                ar[x].add(y);
                ar[y].add(x);
            } else if (input.equals("d")) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                /* (int i = 0; i < ar[x].size(); i++) {
                    if (ar[x].get(i) == y) {
                        ar[y].remove(i);
                        break;
                    }
                }
                for (int i = 0; i < ar[y].size(); i++) {
                    if (ar[y].get(i) == x) {
                        ar[y].remove(i);
                        break;
                    }
                }

                 */
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                for (int i = 0; i < ar[a].size(); i++) {
                    if (ar[a].get(i) == b) {
                        ar[a].remove(i);
                        break;
                    }
                }
                for (int i = 0; i < ar[b].size(); i++) {
                    if (ar[b].get(i) == a) {
                        ar[b].remove(i);
                        break;
                    }
                }
            } else if (input.equals("n")) {
                int x = scanner.nextInt();
                System.out.println(ar[x].size());
            } else if (input.equals("f")) {
                int x = scanner.nextInt();
                /*
                HashSet<Integer> ff = new HashSet<>();
                ArrayList<Integer> f = new ArrayList<>();
                f.add(x);
                for (int friend : ar[x]) {
                    f.add(friend);
                    for (int ffriend : ar[friend]) {
                        ff.add(ffriend);
                    }
                }
                System.out.println(ff.size()-f.size());

                 */
                List<Integer> ans = new ArrayList<>(), friends = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                friends.add(x);
                for (int i = 0; i < ar[x].size(); i++) {
                    queue.add(ar[x].get(i));
                    friends.add(ar[x].get(i));
                }
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int nxt : ar[cur]) {
                        if (!ans.contains(nxt) && !friends.contains(nxt)) ans.add(nxt);
                    }
                }
                System.out.println(ans.size());
            } else if (input.equals("s")) {
                /*int x = scanner.nextInt();
                int y = scanner.nextInt();
                int[] smallestDistance = new int[51];
                HashSet<Integer> hSet = new HashSet<>();
                smallestDistance[x] = 0;
                hSet.add(x);
                Queue<Integer> queue = new LinkedList();
                queue.add(x);
                while (!queue.isEmpty()) {
                    int nextFriend = queue.poll();
                    for (int friend : ar[nextFriend]) {
                        if (!hSet.contains(friend)) {
                            hSet.add(friend);
                            smallestDistance[friend] = smallestDistance[nextFriend] + 1;
                            queue.add(friend);
                        }
                    }
                }
                if (hSet.contains(y)) {
                    System.out.println(smallestDistance[y]);
                } else {
                    System.out.println("Not connected");
                }

                 */
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int[] dis = new int[51];
                boolean[] vis = new boolean[51];
                vis[a] = true;
                dis[a] = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(a);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int nxt : ar[cur]) {
                        if (!vis[nxt]) {
                            queue.add(nxt);
                            vis[nxt] = true;
                            dis[nxt] = dis[cur] + 1;
                        }
                    }
                }
                if (!vis[b]) System.out.println("Not connected");
                else System.out.println(dis[b]);
            }
            input = scanner.nextLine();
        }
    }

/*
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        public Edge(int source, int destination ) {
            this(source, destination,1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return source == edge.source && destination == edge.destination;

        }
        @Override
        public int hashCode() {
            return Objects.hash(source, destination);
        }
    }

    static class Graph {

        Map<Integer,Set<Edge>>  adjacencyMap = new HashMap();

        boolean graphChanged=false;
        Graph() {

        }


        private void addEdge(int source, int destination){
            Edge edge = new Edge(source, destination);
            Set<Edge>  sourceAdjacencySet=adjacencyMap.get(source);
            if (sourceAdjacencySet==null){
                sourceAdjacencySet=new HashSet<>();
                adjacencyMap.put(source,sourceAdjacencySet);
            }
            sourceAdjacencySet.add(edge);

        }

        public void addFriendship(int source, int destination) {
            addEdge(source,destination);
            addEdge(destination, source);
            graphChanged=true;
        }
        public void removeFriendship(int source, int destination) {
            removeEdge(source,destination);
            removeEdge(destination, source);

        }
        private void removeEdge(int source, int destination){
            Edge edge = new Edge(source, destination);
            Set<Edge>  sourceAdjacencySet=adjacencyMap.get(source);
            if (sourceAdjacencySet!=null){
                sourceAdjacencySet.remove(edge);
                graphChanged=true;
            }

        }

        public Map<Integer,Integer> getMinDistances(int sourceVertex){
            int vertices =adjacencyMap.size();

            Set<Integer> visited=new HashSet();
            //distance used to store the distance of vertex from a source
            Map<Integer,Integer> distance = new HashMap<>();
            for (int vertex: adjacencyMap.keySet()) {
                distance.put( vertex,Integer.MAX_VALUE);
            }

            //Initialize priority queue
            //override the comparator to do the sorting based keys
            Queue<SimpleEntry<Integer, Integer>> shortestDistanceVertexQueue = new PriorityQueue<SimpleEntry<Integer, Integer>>(vertices, new Comparator<SimpleEntry<Integer, Integer>>() {
                @Override
                public int compare(SimpleEntry<Integer, Integer> p1, SimpleEntry<Integer, Integer> p2) {
                    //sort using distance values
                    int distance1 = p1.getKey();
                    int distance2 = p2.getKey();
                    return distance1-distance2;
                }
            });
            //create the SimpleEntry for for the first index, 0 distance 0 index

            distance.put(sourceVertex,0);
            SimpleEntry<Integer, Integer> p0 = new SimpleEntry<>(0,sourceVertex);
            //add it to pq
            shortestDistanceVertexQueue.offer(p0);

            //while priority queue is not empty
            while(!shortestDistanceVertexQueue.isEmpty()){
                //extract the min
                SimpleEntry<Integer, Integer> extractedSimpleEntry = shortestDistanceVertexQueue.poll();

                //extracted vertex
                int extractedVertex = extractedSimpleEntry.getValue();
                if(!visited.contains(extractedVertex)) {
                    visited.add(extractedVertex);

                    //iterate through all the adjacent vertices and update the keys
                    Set<Edge> edgeSet= adjacencyMap.get(extractedVertex);
                    Edge[] list = edgeSet.toArray(new Edge[edgeSet.size()]);
                    for (Edge edge:list) {

                        int destination = edge.destination;
                        //only if edge destination is not visited
                        if (!visited.contains(destination)) {
                            ///check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance
                            int newDistance=  distance.get(extractedVertex) + edge.weight ;
                            int currentDistance = distance.get(destination) ;
                            if(currentDistance>newDistance){
                                SimpleEntry<Integer, Integer> p = new SimpleEntry<>(newDistance, destination);
                                shortestDistanceVertexQueue.offer(p);
                                distance.put(destination,newDistance);
                            }
                        }
                    }
                }
            }
            return distance;
        }
        Map<Integer,Map<Integer,Integer>>  distanceMap=new HashMap<>();

        public  Map<Integer,Map<Integer,Integer>> getMinDistanceMap() {
            if (graphChanged) {
                distanceMap.clear();
                for (int source: adjacencyMap.keySet()) {
                    distanceMap.put(source, getMinDistances(source));
                }
                graphChanged=false;
            }
            return distanceMap;

        }
        long countFriend(int vertex){
            return getMinDistanceMap()
                    .get(vertex)
                    .entrySet()
                    .stream()
                    .filter( key -> key.getValue()==1 )
                    .count();


        }

        long countFriendOfFriend(int vertex){
            return getMinDistanceMap()
                    .get(vertex)
                    .entrySet()
                    .stream()
                    .filter( key -> key.getValue()==2 )
                    .count();

        }
        String  countDegreeOfSeparation(int v1, int v2){
            int  degree= getMinDistanceMap().get(v1).get(v2);


            if (degree==Integer.MAX_VALUE) {
                return "Not connected";
            }else {
                return degree+"";
            }

        }


    }
*/
}