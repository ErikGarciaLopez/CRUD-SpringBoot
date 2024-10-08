async function loadCustomer() {
    if (isNew()){
        return;
    }

    let id = getCustomerId();
    let customer = await getCustomerById(id);
    
    document.getElementById('txtFirstName').value = customer.firstname;
    document.getElementById('txtLastName').value = customer.lastname;
    document.getElementById('txtEmail').value = customer.email;
    document.getElementById('txtAddress').value = customer.address;
}

function getCustomerId() {
    let auxSplit= window.location.href.split('id=')
    let id = auxSplit[1];
    return id;
}

function isNew() { //Si es nuevo regresa 1
    let hasIdInURL = window.location.href.includes('id=');
    return !hasIdInURL;
}

async function getCustomerById(id) {
    let url = URL_SERVER + 'customer/' + id;
    let response = await fetch(url);
    let json = await response.json();
    return json;
}

function clickCreate() {

    let firstname = document.getElementById('txtFirstName').value
    let lastname = document.getElementById('txtLastName').value
    let email = document.getElementById('txtEmail').value
    let address = document.getElementById('txtAddress').value

    let customer = {
        "firstname": firstname,
        "lastname": lastname,
        "email": email,
        "address": address
    };
    save(customer);
}

async function save(customer){
    let url = URL_SERVER + 'customer';
    let methodType = isNew() ? 'POST' : 'PUT';

    if(!isNew()) {
        url += '/' + getCustomerId();
    }

    let config = {
        "method": methodType,
        "body": JSON.stringify(customer), 
        "headers": {
            'Content-Type': 'application/json'
        }
    };

    await fetch(url, config);
    alert('El cliente se guardo correctamente')
    window.location.href = 'customers.html';
}

loadCustomer();