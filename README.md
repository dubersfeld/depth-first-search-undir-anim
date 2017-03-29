# depth-first-search-undir-anim
Java based animated demonstration of Depth First Search algorithm applied to find the connected components of an undirected graph.

I present here an animated demonstration of the Depth First Search algorithm applied to an undirected graph.

An undirected graph is randomly initialized (browser side) and sent to server side as a JSON object.

Then a DFS algorithm is performed on the graph (server side) and all intermediate results are saved as a collection.

This collection is sent back to the browser as a JSON object.

The collection is then used for animation. All vertices are colored according to the comnponent they belong to.

When deployed on Tomcat the root context is:

undirected-components

Dominique Ubersfeld, Cachan, France  
