import {baseUrl} from "./constants.js";
export const login = () => {
    console.log(baseUrl + "/login");
    let data;

    let myHeaders = new Headers();
    myHeaders.append("Authorization", "");

    let requestOptions = {
        method: 'POST',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch(baseUrl + "/login", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}
