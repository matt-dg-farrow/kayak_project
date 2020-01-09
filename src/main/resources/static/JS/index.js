function tableSearch() {
    // Declare variables
    var tr, td, i, j, txtValue;
    tr = document.getElementById("table-of-customers").getElementsByTagName("tr");
  
    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        // for (j = 0; j < 6; j++) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(document.getElementById("search-box").value.toUpperCase()) > -1) {
          tr[i].style.display = "";
        } 
        else {
          tr[i].style.display = "none";
        }
      }
    }
  }



// function getCustomers(){
//   axios.get("http://localhost:8080/getCustomer")
//       .then((response) => {
//           console.log(response.data);
//           getCustomerInfo(response.data);
//       }).catch((error) =>{
//           console.log(error);
//       });

// }

// const customerList = document.getElementById("table-body");

// function getCustomerInfo(customers) {
//   // if(customerList.innerHTML.length===0){
//   for(let customer of customers) {
//     console.log("####");
//     let customerInfo = document.createElement("tr");

//     let customerFirstName = document.createElement("td");
//     customerFirstName.innerHTML = customer.custFirstName;
//     customerInfo.appendChild(customerFirstName);

//     let customerSurname = document.createElement("td");
//     customerSurname.innerHTML = customer.custSurname;
//     customerInfo.appendChild(customerSurname);

//     let emergFirstName = document.createElement("td");
//     emergFirstName.innerHTML = customer.emergFirstName;
//     customerInfo.appendChild(emergFirstName);

//     let emergSurname = document.createElement("td");
//     emergSurname.innerHTML = customer.emergSurname;
//     customerInfo.appendChild(emergSurname);

//     let emergContactNumber = document.createElement("td");
//     emergContactNumber.innerHTML = customer.emergContactNumber;
//     customerInfo.appendChild(emergContactNumber);

//     let emergRelation = document.createElement("td");
//     emergRelation.innerHTML = customer.emergRelation;
//     customerInfo.appendChild(emergRelation);

//     customerList.appendChild(customerInfo);
//   }
//   // location.reload();

// }

function addCustomer(){
    // debugger;

  let newCustFirstName = document.getElementById("newCustFirstName");
  let newCustSurname = document.createElement("newCustSurname");
  let newEmergFirstName = document.createElement("newEmergFirstName");
  let newEmergSurname = document.createElement("newEmergSurname");
  let newEmergContactNumber = document.createElement("newEmergContactNumber");
  let newEmergRelation = document.createElement("newEmergRelation");
  console.log(customerFirstName);
  // debugger;
  axios.post('http://localhost:8080/createCustomer', {
    custFirstName:"Bob",
    custSurname:"Bobby",
    emergFirstName:"Sue",
    emergSurname:"Sister",
    emergContactNumber:"07878123456",
    emergRelation:"Bobby",
    equipment:[]
  }).then(response => {console.log(response); location.reload();});

}


const customerData =
  axios.get("http://localhost:8080/getCustomer")
      .then((response) => {console.log(response.data);
                    return response.data;});

const customerList = document.getElementById("table-body");

function getCustomerInfo() {
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
