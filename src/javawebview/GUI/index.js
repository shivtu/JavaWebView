function printHello(){
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/hello', true);
    xhr.onload = function () {
    if(xhr.readyState === 4){ 
        console.log('response '+this.responseText);
        document.getElementById('helloId').innerHTML = this.responseText;
        }else{
            document.getElementById('helloId').innerHTML = 'No response from the Java engine';
        }
    };
    xhr.send(null);
}
