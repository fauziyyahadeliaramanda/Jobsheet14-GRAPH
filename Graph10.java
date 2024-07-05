public class Graph10 {
    int vertex;
    int[][] matriks;
    DoubleLinkedList10[] list;

    public Graph10(int vertex) {
        this.vertex = vertex;
        list = new DoubleLinkedList10[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new DoubleLinkedList10();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak) {
        list[asal].addFirst(tujuan, jarak);
        list[tujuan].addFirst(asal, jarak);  // Comment this line if it's a directed graph
    }

    public void removeEdge(int asal, int tujuan) throws Exception {
        list[asal].remove(tujuan);
    }

    public void removeAllEdges() {
        for (int i = 0; i < vertex; i++) {
            list[i].clear();
        }
    }

    public void degree(int asal) throws Exception {
        int totalIn = 0, totalOut = list[asal].size();

        for (int i = 0; i < vertex; i++) {
            if (i != asal) {
                for (int j = 0; j < list[i].size(); j++) {
                    if (list[i].get(j) == asal) {
                        totalIn++;
                    }
                }
            }
        }

        System.out.println("InDegree dari Gedung " + (char) ('A' + asal) + ": " + totalIn);
        System.out.println("OutDegree dari Gedung " + (char) ('A' + asal) + ": " + totalOut);
        System.out.println("Degree dari Gedung " + (char) ('A' + asal) + ": " + (totalIn + totalOut));
    }

    public void printGraph10() throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.print("Gedung " + (char) ('A' + i) + " terhubung dengan: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print((char) ('A' + list[i].get(j)) + "(" + list[i].getJarak(j) + "m), ");
                }
                System.out.println();
            }
        }
    }

    public int inDegree(int node) {
        int inDegreeCount = 0;
        for (int i = 0; i < vertex; i++) {
            if (matriks[i][node] != 0) {
                inDegreeCount++;
            }
        }
        return inDegreeCount;
    }
    
    public int outDegree(int node) {
        int outDegreeCount = 0;
        for (int j = 0; j < vertex; j++) {
            if (matriks[node][j] != 0) {
                outDegreeCount++;
            }
        }
        return outDegreeCount;
    }
    

    public boolean isAdjacent(int asal, int tujuan) {
        for (int i = 0; i < list[asal].size(); i++) {
            try {
                if (list[asal].get(i) == tujuan) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


public void updateJarak(int asal, int tujuan, int jarakBaru) {
    matriks[asal][tujuan] = jarakBaru;
}

public int hitungEdge() {
    int edgeCount = 0;
    for (int i = 0; i < vertex; i++) {
        for (int j = 0; j < vertex; j++) {
            if (matriks[i][j] != 0) {
                edgeCount++;
            }
        }
    }
    return edgeCount;
}

public void makeEdge(int i, int j, int k) {
    throw new UnsupportedOperationException("Unimplemented method 'makeEdge'");
}
}

