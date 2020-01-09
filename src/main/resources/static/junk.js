
const customerData =
  axios.get("http://localhost:8080/getCustomer")
      .then((response) => {console.log(response.data);
                    return response.data;});

const customerList = document.getElementById("table-body");

function getCustomerInfo(customers) {
  // if(customerList.innerHTML.length===0){
  customerData.then(customers => {
  for(let customer of customers) {
    console.log("####");
    let customerInfo = document.createElement("tr");

    let customerFirstName = document.createElement("td");
    customerFirstName.innerHTML = customer.custFirstName;
    customerInfo.appendChild(customerFirstName);

    let customerSurname = document.createElement("td");
    customerSurname.innerHTML = customer.custSurname;
    customerInfo.appendChild(customerSurname);

    let emergFirstName = document.createElement("td");
    emergFirstName.innerHTML = customer.emergFirstName;
    customerInfo.appendChild(emergFirstName);

    let emergSurname = document.createElement("td");
    emergSurname.innerHTML = customer.emergSurname;
    customerInfo.appendChild(emergSurname);

    let emergContactNumber = document.createElement("td");
    emergContactNumber.innerHTML = customer.emergContactNumber;
    customerInfo.appendChild(emergContactNumber);

    let emergRelation = document.createElement("td");
    emergRelation.innerHTML = customer.emergRelation;
    customerInfo.appendChild(emergRelation);

    customerList.appendChild(customerInfo);
  }})
}