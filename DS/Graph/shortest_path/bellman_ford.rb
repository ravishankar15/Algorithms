# Find the shortest path from src to all the vertices
def naive_bellman_ford(edges, vertices, src)
    int_max = 2**31
    # Step 1: Initialize distances from src to all other
    # vertices as INFINITE
    v = vertices; e = edges.size
    dist = Array.new(v, int_max)
    dist[src] = 0

    # Step 2: Relax all edges |V| - 1 times. A simple
    # shortest path from src to any other vertex can
    # have at-most |V| - 1 edges
    for i in 1...v
        for j in 0...e
            u = edges[j][0]
            v = edges[j][1]
            w = edges[j][2]

            if dist[u] != int_max && dist[u] + w < dist[v]
                dist[v] = dist[u] + w
            end
        end
    end


    # Step 3: check for negative-weight cycles. The above
    # step guarantees shortest distances if graph doesn't
    # contain negative weight cycle. If we get a shorter
    # path, then there is a cycle.
    for j in 0...e
        u = edges[j][0]
        v = edges[j][1]
        w = edges[j][2]

        if dist[u] != int_max && dist[u] + w < dist[v]
            return -1
        end
    end

    dist
end

# Find the shortest path from src to all the vertices BF - Shortest Path Faster Algorithm
def bellman_ford_spfa(edges, vertices, src)
    graph = {}; int_max = 2**31
    edges.each do |edge|
        graph[edge[0]] = [] if graph[edge[0]].nil?
        graph[edge[0]] << [edge[1], edge[2]]
    end

    # Step 1: Initialize distances from src to all other
    # vertices as INFINITE
    v = vertices; e = edges.size
    inq = Array.new(v, false)
    dist = Array.new(v, int_max)
    dist[src] = 0
    inq[src] = true
    q = [src]

    while (!q.empty?)
        u = q.shift
        inq[u] = false
        if !graph[u].nil?
            graph[u].each do |edge|
                v = edge[0]; w = edge[1]

                if dist[u] != int_max && dist[u] + w < dist[v]
                    dist[v] = dist[u] + w

                    if !inq[v]
                        inq[v] = true
                        q << v
                    end
                end
            end
        end
    end

    # Step 3: check for negative-weight cycles. The above
    # step guarantees shortest distances if graph doesn't
    # contain negative weight cycle. If we get a shorter
    # path, then there is a cycle.
    for j in 0...e
        u = edges[j][0]
        v = edges[j][1]
        w = edges[j][2]

        if dist[u] + w < dist[v]
            return -1
        end
    end

    dist
end
puts naive_bellman_ford([[0,1,-1],[0,2,4],[1,2,3],[1,3,2],[1,4,2],[3,2,5],[3,1,1],[4,3,-3]], 5, 0).inspect #[0,-1,2,-2,1]
puts bellman_ford_spfa([[0,1,-1],[0,2,4],[1,2,3],[1,3,2],[1,4,2],[3,2,5],[3,1,1],[4,3,-3]], 5, 0).inspect #[0,-1,2,-2,1]