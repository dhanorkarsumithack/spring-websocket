var stompClient=null;

function connect(){
    var socket= new SockJS("http://localhost:8087/ws");

    stompClient = Stomp.over(socket);

    stompClient.connect({}, function(frame){
        console.log("frame received on server "+frame);

        stompClient.subscribe("/topic/prime",function(data){
            console.log("data "+data.body)
            $("#messages").append("<li>"+data.body+"</li>");
        });

    })

}