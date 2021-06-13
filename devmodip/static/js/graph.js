jQuery(function () {
    var cy = cytoscape({
        container: $('#cy'),
        elements: [ // list of graph elements to start with
            { // node a
                data: {id: 'a'}
            },
            { // node b
                data: {id: 'b'}
            },
            { // edge ab
                data: {id: 'ab', source: 'a', target: 'b'}
            }
        ],

        style: [ // the stylesheet for the graph
            {
                selector: 'node',
                style: {
                    'background-color': 'white',
                    'label': 'data(id)'
                }
            },

            {
                selector: 'edge',
                style: {
                    'width': 2,
                    'line-color': 'green',
                    'curve-style': 'bezier'
                }
            }
        ],

        layout: {
            name: 'grid',
            rows: 5
        }
    });
});