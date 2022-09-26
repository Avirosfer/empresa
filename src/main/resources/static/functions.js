function deleteEmployee(id)
{
    swal({
      title: "Are you sure to delete?",
      text: "Once deleted, you will not be able to recover this file!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((OK) => {
      if (OK) {
            $.ajax({
            url:"/deleteEmployee/"+id,
            success: function(res){
                console.log(res);
            }
            });
        swal("Phew! Your file has been deleted!", {
          icon: "success",
        }).then(()=>{
            if(ok){
                location.href="/showNewEmployeeForm";
            }
        });
      } else {
        swal("Your file has been Saved!");
      }
    });
}