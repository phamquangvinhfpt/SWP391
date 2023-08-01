function format(d) {
    // `d` is the original data object for the row
    return (
            '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
            '<tr>' +
            '<td>Image:</td>' +
            '<td>' +
            '<img src="images/' + d.Image + '" width="100px" height="100px"/>' +
            '</td>' +
            '</tr>' +
            '<tr>' +
            '<td>Address:</td>' +
            '<td>' +
            d.Address +
            '</td>' +
            '</tr>' +
            '<tr>' +
            '<td>Project:</td>' +
            '<td>' + d.NameProject + '</td>' +
            '</tr>' +
            '<tr>' +
            '</tr>' +
            '</table>'
            );
}
$(document).ready(function () {
    //load data for datatable
    $('#example').DataTable({

        ajax: {
            url: '/HRManagement/employee',
            dataSrc: ''
        },
        //justify content table center
        "columnDefs": [
            {"className": "dt-center", "targets": "_all"}
        ],
        columns: [
            {
                className: 'dt-control',
                orderable: false,
                data: null,
                defaultContent: ''
            },
            {data: null,
                //set identity for row
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {data: 'Name'},
            {data: 'Phone'},
            {data: 'Email'},
            {data: 'Birthday'},
            {
                data: null,
                render: function (data, type, row) {
                    //set id for button = id of employee
                    return `
            <button style="background-color: white;box-shadow: none" class="del-employee btn m-1"><i class="fa-solid fa-trash text-danger"></i></button>
            <button style="background-color: white;box-shadow: none" class="edit-employee btn m-1"><i class="fa-solid fa-pen-to-square text-primary"></i></button>
        `;
                }
            }
        ],
        "order": [[0, "asc"]]
    });

    // Add event listener for opening and closing details
    $('#example tbody').on('click', 'td.dt-control', function () {
        var tr = $(this).closest('tr');
        var row = $('#example').DataTable().row(tr);

        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        } else {
            // Open this row
            row.child(format(row.data())).show();
            tr.addClass('shown');
        }
    });

    $(document).ready(function () {
        //reset form when click button add
        $(".btn-add").click(function () {
            $(".myform").trigger("reset");
            $("#mymodal").modal("show");
            $("#mymodal .modal-title").text("Add Employee");
            $("#mymodal .modal-footer button").text("Add");
            $("#mymodal .modal-footer button").attr("id", "addEmployee");
            //add employee
        });
        //delete employee
        //set event for button delete employee in table 
        $('#example tbody').on('click', '.del-employee', function () {
            //get data of row which is clicked
            var data = $('#example').DataTable().row($(this).parents('tr')).data();
            //set id for button delete
            var id = data.UserID;
            //console id of employee
            console.log(id);
            //use method post to send id to server
            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success',
                    cancelButton: 'btn btn-danger'
                },
                buttonsStyling: false
            });
            swalWithBootstrapButtons.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Yes, delete it!',
                cancelButtonText: 'No, cancel!',
                reverseButtons: true
            }).then((result) => {
                if (result.isConfirmed) {
                    swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'Your file has been deleted.',
                            'success'
                            );
                    $.ajax({
                        method: "POST",
                        url: "/HRManagement/deleteEmployee?id=" + id + "",
                        success: function (res) {
                            console.log(res);
                            //remove "" from string
                            if (res === "success") {
                                swal.fire({
                                    title: "Success!",
                                    text: "Delete employee success!",
                                    icon: "success",
                                    button: "OK"
                                }).then((value) => {
                                    //click oke will hide modal and reload datatable
                                    $("#mymodal").modal("hide");
                                    $('#example').DataTable().ajax.reload();
                                });
                            } else {
                                swal.fire({
                                    title: "Error!",
                                    //remove "" from string
                                    text: res.replace(/"/g, ""),
                                    icon: "error",
                                    button: "OK!"
                                });
                            }
                        },
                        error: function (error) {
                            console.log(error);
                            sweetAlert("Oops...", "Something went wrong!", "error");
                        }
                    });
                } else if (
                        /* Read more about handling dismissals below */
                        result.dismiss === Swal.DismissReason.cancel
                        ) {
                    swalWithBootstrapButtons.fire(
                            'Cancelled',
                            'Your employee is safe :)',
                            'error'
                            );
                }
            });
        });
        //edit employee
        //set event for button edit employee in table
        $('#example tbody').on('click', '.edit-employee', function () {
            //get data of row which is clicked
            var data = $('#example').DataTable().row($(this).parents('tr')).data();
            //set id for button edit
            var id = data.UserID;
            //get image
            var image = data.Image;
            //console id of employee
            console.log(id);
            //get birthday of employee
            var birthday = data.Birthday;
            console.log(birthday);
            //convert birthday to date to set value for input date
            var date = new Date(birthday);
            var isoDate = new Date(date.getTime() - (date.getTimezoneOffset() * 60000)).toISOString().split("T")[0];
            console.log(isoDate);
            //show modal
            $("#editmodal").modal("show");
            var image = data.Image;
            //set title for modal
            //import a input hidden to modal
            $("#editmodal .modal-body").append("<input type='hidden' name='id' value='" + id + "'>");
            $("#editmodal input[name='name']").val(data.Name);
            $("#editmodal input[name='phone']").val(data.Phone);
            $("#editmodal input[name='email']").val(data.Email);
            $("#editmodal input[name='username']").val(data.Username);
            $("#editmodal input[name='password']").val("");
            $("#editmodal input[name='address']").val(data.Address);
            $("#editmodal input[name='projectName']").val(data.NameProject);
            $("#editmodal input[name='teamName']").val(data.Team_Name);
            $("#editmodal input[name='birthday']").val(isoDate);
            //add image to div has id = "avatar"
            $("#avatar").html("<img src='/HRManagement/images/" + image + "' width='100px' height='100px' alt=''>");
            //sent all data to server
        });
    });
    //add
    $(document).ready(function () {
        $(".myform").on("submit", function (e) {
            e.preventDefault();
            $.ajax({
                method: "POST",
                url: "/HRManagement/addEmployee",
                data: new FormData(this),
                processData: false,
                contentType: false,
                success: function (res) {
                    console.log(res);
                    //remove "" from string
                    if (res === `"Insert success"`) {
                        swal.fire({
                            title: "Success!",
                            text: "Add employee success!",
                            icon: "success",
                            button: "OK"
                        }).then((value) => {
                            //click oke will hide modal and reload datatable
                            $("#mymodal").modal("hide");
                            $('#example').DataTable().ajax.reload();
                        });
                    } else {
                        swal.fire({
                            title: "Error!",
                            //remove "" from string
                            text: res.replace(/"/g, ""),
                            icon: "error",
                            button: "OK!"
                        });
                    }
                },
                error: function (error) {
                    console.log(error);
                    sweetAlert("Oops...", "Something went wrong!", "error");
                }
            });
        });
    });
    //edit
    $(document).ready(function () {
        $(".editform").on("submit", function (e) {
            e.preventDefault();
            $.ajax({
                method: "POST",
                url: "/HRManagement/editEmployee",
                data: new FormData(this),
                processData: false,
                contentType: false,
                success: function (res) {
                    console.log(res);
                    //remove "" from string
                    if (res === `"Edit success"`) {
                        swal.fire({
                            title: "Success!",
                            text: "Edit employee success!",
                            icon: "success",
                            button: "OK"
                        }).then((value) => {
                            //click oke will hide modal and reload datatable
                            $("#editmodal").modal("hide");
                            $('#example').DataTable().ajax.reload();
                        });
                    } else {
                        swal.fire({
                            title: "Error!",
                            //remove "" from string
                            text: res.replace(/"/g, ""),
                            icon: "error",
                            button: "OK!"
                        });
                    }
                },
                error: function (error) {
                    console.log(error);
                    sweetAlert("Oops...", "Something went wrong!", "error");
                }
            });
        });
    });
    //selected employee
    $(document).ready(function () {
        var table = $('#example').DataTable();

        $('#example tbody').on('click', 'tr', function () {
            $(this).toggleClass('selected');
            //the first row is selected will show toast notify to user know can delete multiple selected employees then the another row is selected will not show toast notify
            if (table.rows('.selected').data().length === 1) {
                Toastify({
                    //show message to show user know can delete employee by press delete button
                    text: "Press delete button to delete multiple selected employees",
                    duration: 3000,
                    gravity: "top",
                    position: "right",
                    backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
                    stopOnFocus: true,
                    onclick: function () {}
                }).showToast();
            }
        });
        $('#button').click(function () {
            alert(table.rows('.selected').data().length + ' row(s) selected');
        });
    });

    $(document).on('keydown', function (e) {
        if (e.keyCode === 27) { // ESC
            $("#mymodal").modal("hide");
            $("#editmodal").modal("hide");
        }
        if (e.key === 'Delete') {
            var selectedRows = $('#example').DataTable().rows('.selected').data();
            //Get id of selected employees
            var selectedId = [];
            for (var i = 0; i < selectedRows.length; i++) {
                selectedId.push(selectedRows[i].UserID);
            }
            // console.log(selectedId);
            if (selectedRows.length > 0) {
                Toastify({
                    //show message to show user know can delete employee by press delete button
                    text: "Press delete button to delete multiple selected employees",
                    duration: 3000,
                    gravity: "top",
                    position: "right",
                    backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
                    stopOnFocus: true,
                    onclick: function () {}
                }).showToast();
                //send DELETE request to server to delete selected employees
                const swalWithBootstrapButtons = Swal.mixin({
                    customClass: {
                        confirmButton: 'btn btn-success',
                        cancelButton: 'btn btn-danger'
                    },
                    buttonsStyling: false
                });
                swalWithBootstrapButtons.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Yes, delete it!',
                    cancelButtonText: 'No, cancel!',
                    reverseButtons: true
                }).then((result) => {
                    if (result.isConfirmed) {
                        swalWithBootstrapButtons.fire(
                                'Deleted!',
                                'Employee has been deleted.',
                                'success'
                                );
                        $.ajax({
                            method: "DELETE",
                            url: "/HRManagement/deleteEmployee",
                            data: JSON.stringify(selectedId),
                            contentType: "application/json",
                            dataType: "json",
                            // console: console.log(JSON.stringify(selectedId)),
                            success: function (res) {
                                var message = res.message;
                                //remove "" from string
                                message = message.replace(/"/g, "");
                                console.log(message);
                                //if message = "Delete successfully"
                                if (message === "Delete successfully") {
                                    //reload datatable
                                    $('#example').DataTable().ajax.reload();
                                }
                            },
                            error: function (error) {
                                console.log(error);
                                sweetAlert("Oops...", "Something went wrong!", "error");
                            }
                        });
                    } else if (
                            /* Read more about handling dismissals below */
                            result.dismiss === Swal.DismissReason.cancel
                            ) {
                        swalWithBootstrapButtons.fire(
                                'Cancelled',
                                'Your employee is safe :)',
                                'error'
                                );
                    }
                });
            }
        }
    });
});