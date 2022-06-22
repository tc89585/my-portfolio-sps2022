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
const write = () => {
    if (index < text.length) {
        //grab contents of element and concat with text
        document.getElementById("page-one-heading").innerHTML += text.charAt(index);
        index++;
        //execute write function after 200 milliseconds 
        setTimeout(write, speed);
    }
} //write

/**
 * Displays blinking cursor effect.
 */
const cursorEffect = () => {
    
} //cursorEffect

window.onload = write;

/**
 * View a list of received messages from datastore, hiding personal info.
 * 
 * postCondition: display html page of received messages
 */
const viewReceivedMessages = async () => {
    const response = await fetch('/list-responses');
    const json = await response.json();

    const messageContainer = document.getElementById('response-container');

    messageContainer.innerHTML = JSON.stringify(json);
}


