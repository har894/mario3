//make some simple axes with tick marks
//assumes a square canvas, but that could probably be changed
ws = new WebSocket("ws://127.0.0.1:5678/")
let points = [];
function setup() {

    myCanvas = createCanvas(700, 700);
    myCanvas.parent("graph");
}

function draw() {

    background(250);
    translate(width/2,height/2)
    //primary axes
    drawTickAxes(0,1,10,0,0)
    drawDetectors(-100, 70, 'green')
    drawDetectors(100, 200, 'yellow')
    ws.onmessage = function (event) {
        // x = event.data.split(',')[0]
        // y = event.data.split(',')[1]
        points.push(event.data)
    };
    drawObjects(points)
        //Do something

    //offset secondary axes that are red and move
    //with the mouse position
    // drawTickAxes(color(250,100,100,100),1,10,mouseX-width/2,(mouseY-height/2))
}

function drawTickAxes(lineColor,thickness,spacing,xoffset,yoffset) {
    this.lineColor = lineColor;
    this.thickness = thickness;
    this.spacing = spacing;
    this.xoffset = xoffset;
    this.yoffset    = yoffset;
    push();
    translate(this.xoffset,this.yoffset)
    stroke(this.lineColor)
    for (var i = 0; i<height/2; i+=this.spacing){

        //vertical tickmarks
        line(+3,i,-3,i)
        line(+3,-i,-3,-i)

        //horizontal tickmarks
        line(i,+3,i,-3)
        line(-i,+3,-i,-3)
    }
    stroke(this.lineColor)
    strokeWeight(this.thickness);
    //horizontal line
    line(-width/2,0,+width/2,0)
    //vertical line
    line(0,height/2,0,-height/2)

    pop();

}

function drawDetectors(xoffset, yoffset, color) {
    fill(color)
    rect(xoffset,-yoffset, 20, 20);
}

function drawObjects(points) {
    for (let i = 0; i < points.length; i++) {
        fill('red')
        ellipse(points[i].split(',')[0], points[i].split(',')[1], 5, 5);
    }
}
// drawObject(12, 52)