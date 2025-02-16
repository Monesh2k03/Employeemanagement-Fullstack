getAllUser();
function getAllUser(){
    fetch("http://localhost:8080/api/employee/getall",
        {
        headers: {
            'content-Type':'application/json'
        },
        method: 'GET'

})
.then(Response => Response.json())
.then(data => {
    
      for(let i = 0;i<data.length;i++){

        let {id,firstname,lastname,email} = data[i]

        let tbl = document.getElementById('tbl')

        let newRow = tbl.insertRow(-1);

        let idcol = newRow.insertCell(0);
        let firstnamecol = newRow.insertCell(1);
        let lastnamecol = newRow.insertCell(2);
        let emailcol = newRow.insertCell(3);
        let btncol = newRow.insertCell(4);

        idcol.textContent = id;
        firstnamecol.textContent = firstname;
        lastnamecol.textContent = lastname;
        emailcol.textContent = email;
        btncol.innerHTML = `<button class="btn-upt" onclick="userupdate(this)">Update</button>
                            <button class="btn-dlt" onclick="userdelete(this)">Delete</button>`;

      }
})
.catch(error => {
    console.error('Error fetching data:', error);
  });
}



let addemp = document.getElementById('addemp');
let uptemp = document.getElementById('uptemp');
let bodycont = document.getElementById('bodycont')

function add(){
    bodycont.style.filter = "blur(10px)";
    addemp.style.display = "flex";


}

function off(){
    bodycont.style.filter = "blur(0)";
    addemp.style.display = "none";
    uptemp.style.display = "none";

}

function taboff(){
    bodycont.style.filter = "blur(0)";
    addemp.style.display = "none";
    uptemp.style.display = "none";

}

function saveuser(){
    
    let first = document.getElementById('first').value;
    let last = document.getElementById('last').value;
    let emailid = document.getElementById('email').value;

    let msg = document.getElementById('msg')



    if(first == null || last == null || emailid==null ){
        msg.textContent = "fill all the input fields"
    }

    const obj = {
        firstname:first,
        lastname:last,
        email:emailid
    }




    fetch("http://localhost:8080/api/employee/save",
        {
        headers: {
            'content-Type':'application/json'
        },
        method: 'POST',
        body: JSON.stringify(obj)

})
.then(Response => Response.json())
.then(data => {

    alert("User Registered Sucessfully")
    bodycont.style.filter = "blur(0)";
    addemp.style.display = "none";

})
.catch(error => {
    console.error('Error fetching data:', error);
  });
}







let updateid;
function userupdate(button){

    bodycont.style.filter = "blur(10px)";
    uptemp.style.display = "flex";


    let fnamefield = document.getElementById('firstupt');
    let lnamefield = document.getElementById('lastupt');
    let emailfield = document.getElementById('emailupt');

    let row = button.closest("tr");

    let col = row.querySelectorAll("td");

    updateid = col[0].innerText;

    fnamefield.value = col[1].innerText;
    lnamefield.value = col[2].innerText;
    emailfield.value = col[3].innerText;

    
    
}

function updateuserbyID(){
    
    let first = document.getElementById('firstupt').value;
    let last = document.getElementById('lastupt').value;
    let emailid = document.getElementById('emailupt').value;

    let msg = document.getElementById('msg')



    if(first == null || last == null || emailid==null ){
        msg.textContent = "fill all the input fields"
    }

    const obj = {
        firstname:first,
        lastname:last,
        email:emailid
    }




    fetch("http://localhost:8080/api/employee/update"+updateid,
        {
        headers: {
            'content-Type':'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(obj)

})
.then(Response => Response.json())
.then(data => {

    alert("User Updated Sucessfully")
    bodycont.style.filter = "blur(0)";
    uptemp.style.display = "none";

})
.catch(error => {
    console.error('Error fetching data:', error);
  });
}



let deleteid;
function userdelete(button){

    let row = button.closest("tr");

    let col = row.querySelectorAll("td");

    deleteid = col[0].innerText;


    fetch("http://localhost:8080/api/employee/delete"+deleteid,
        {
        headers: {
            'content-Type':'application/json'
        },
        method: 'DELETE'

})
.then(Response => Response.json())
.then(data => {

    alert("User Deleted Sucessfully")

})
.catch(error => {
    console.error('Error fetching data:', error);
  });
    
    
}