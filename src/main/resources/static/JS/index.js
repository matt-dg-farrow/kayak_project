function tableSearch() {
  let tr, td, i, j, txtValue;
  tr = document.getElementById("table-of-customers").getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(document.getElementById("search-box").value.toUpperCase()) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

function highlight(e) {
  if (selected[0]) selected[0].className = '';
  e.target.parentNode.className = 'selected';
  console.log(e);
}

let table = document.getElementById('table-of-customers'),
  selected = table.getElementsByClassName('selected');
table.onclick = highlight;

function deleteCustomer() {
  let id = document.getElementsByClassName("selected")[0].childNodes[0].innerHTML;
  axios.delete("http://localhost:8080//deleteCustomer/" + id)
    .then(response => {
      console.log(response);
      location.reload();
    })
}

function addEquipmentToCust() {
  let custData = document.getElementsByClassName("selected")[0].childNodes;
  let equipList = document.getElementsByClassName("form-check-input");
  let custEquipment = [];
  for (i = 0; i < equipList.length; i++) {
    console.log(equipList[i].id)
    if (equipList[i].checked) {
      custEquipment.push(equipList[i].id)
    }
  }
  axios.put("http://localhost:8080//updateCustomer?id=" + custData[0].innerHTML, {
    custFirstName: custData[1].innerHTML,
    custSurname: custData[2].innerHTML,
    emergFirstName: custData[3].innerHTML,
    emergSurname: custData[4].innerHTML,
    emergContactNumber: custData[5].innerHTML,
    emergRelation: custData[6].innerHTML,
    equipment: custEquipment
  })
}

function addCustomer() {
  let newCustFirstName = document.getElementById("newCustFirstName").value;
  let newCustSurname = document.getElementById("newCustSurname").value;
  let newEmergFirstName = document.getElementById("newEmergFirstName").value;
  let newEmergSurname = document.getElementById("newEmergSurname").value;
  let newEmergContactNumber = document.getElementById("newEmergContactNumber").value;
  let newEmergRelation = document.getElementById("newEmergRelation").value;

  axios.post('http://localhost:8080/createCustomer', {
    custFirstName: newCustFirstName,
    custSurname: newCustSurname,
    emergFirstName: newEmergFirstName,
    emergSurname: newEmergSurname,
    emergContactNumber: newEmergContactNumber,
    emergRelation: newEmergRelation,
    equipment: []
  }).then(response => {
    console.log(response);
    location.reload();
  });
}


const customerData =
  axios.get("http://localhost:8080/getAllCustomers")
  .then((response) => {
    console.log(response.data);
    return response.data;
  });

const customerList = document.getElementById("table-body");

function getCustomerInfo() {
  // if(customerList.innerHTML.length===0){
  customerData.then(customers => {
    for (let customer of customers) {
      console.log("####");
      let customerInfo = document.createElement("tr");

      let customerId = document.createElement("td")
      customerId.innerHTML = customer.id;
      customerId.className = "hidden";
      customerInfo.appendChild(customerId);

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
    }
  })
}

function deleteAll() {
  axios.delete("http://localhost:8080/deleteAllCustomers")
    .then(response => {
      console.log(response);
      location.reload();
    })
}