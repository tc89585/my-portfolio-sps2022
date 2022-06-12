// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

let index = 0;
let text = "TorrinCurry.is()";
let speed = 200; //milliseconds
/**
 * Creates a typing animation.
 */
function write() {
    if (index < text.length) {
        //grab contents of element and concat with text
        document.getElementById("page-one-heading").innerHTML += text.charAt(index);
        index++;
        //execute write function after 200 milliseconds 
        setTimeout(write, speed);
    }
} //write

function cursorEffect() {
    
} //cursorEffect

window.onload = write;

async function getTextFromServer() {
    //send request to Servlet, wait for response object
    const responseFromServer = await fetch("/hello");
    //grab text from response
    const textFromResponse = await responseFromServer.text();

    //get <p> container to hold our text
    const para = document.getElementById("response-container");
    //insert response
    para.innerHTML = textFromResponse;
}
