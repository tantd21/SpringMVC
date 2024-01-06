<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="spring.mvc.Until.Until"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<body>
	<div class="page-header">
		<h3 class="page-title">
			<span class="page-title-icon bg-gradient-primary text-white me-2">
				<i class="mdi mdi-book-variant"></i>
			</span> Quản Lý Admin
		</h3>
		<nav aria-label="breadcrumb">
			<ul class="breadcrumb">
				<li class="breadcrumb-item active" aria-current="page"><i
					class="mdi mdi-timetable"></i> <span> <?php
                    $today = date('d/m/Y');
                    echo $today;
                    ?>
				</span></li>
			</ul>
		</nav>
	</div>

	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<div style="display: flex; justify-content: space-between">
					<div class="card-title col-sm-4">Bảng Danh Sách Admin</div>
					<div class="col-sm-3">
						<div class="input-group">
							<input type="text" class="form-control" id="search_user"
								placeholder="Tìm kiếm">

						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							
						</div>
					</div>
				</div>
				<table style="margin-top: 20px" class="table table-bordered">
					<thead>
						<tr>
							<th>Tên Người Dùng</th>
							<th>Số Điện Thoại</th>
							<th>Email</th>
							<th>Thao Tác</th>
						</tr>
					</thead>
					<tbody id="tbody">
						<c:forEach items="${ customers }" var="customer">
							<tr>
								<td>${ customer.customerName }</td>
								<td>0${ customer.customerPhone }</td>
								<td>${ customer.customerEmail }</td>
								<td><a
									href="/SpringMVC/admin/customers/detail-customer?customerId=${ customer.customerId }">
										<button type="button"
											class="btn btn-inverse-dark btn-icon btn-detail"
											data-delete_id="${ type.productTypeId }" data-restore_id="0">
											<i class="mdi mdi-account-details"></i>
										</button>
								</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal fade" id="unactive" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Bạn có chắc chắn muốn ngưng hoạt động
					của khách hàng này không?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary "
						data-dismiss="modal">Cancel</button>
					<button type="button"
						class="btn btn-primary btn-danger btn_deleted"
						data-dismiss="modal">Chấp nhận</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="active" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Bạn có chắc chắn muốn khách hàng này
					hoạt động lại?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary "
						data-dismiss="modal">Cancel</button>
					<button type="button"
						class="btn btn-primary btn-success btn_deleted"
						data-dismiss="modal">Chấp nhận</button>
				</div>
			</div>
		</div>
	</div>


	<script>
        load_all_user();
        count_delete();
        function load_all_user(){
            $.ajax({
                url: '{{ url('admin/user/loading-user') }}',
                method: 'get',
                data: {
                },
                success: function(data) {
                    $('#tbody').html(data);
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            })
        }
        // function count_delete(){
        //     $.ajax({
        //         url: '{{ url('admin/auth/count-delete') }}',
        //         method: 'get',
        //         data: {
        //         },
        //         success: function(data) {
        //             $('.count-delete').html(data);
        //         },
        //         error: function() {
        //             alert("Bug Huhu :<<");
        //         }
        //     })
        // }
    </script>


	<script>
            $('#search_user').keyup(function(){
                var text = $(this).val();
                $.ajax({
                url: '{{ url('admin/user/search-user') }}',
                method: 'get',
                data: {
                    text: text,
                },
                success: function(data) {
                    $('#tbody').html(data);
                    // count_delete();
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            })
            })

            var customer_id = 0;
            var status = 0;
        $(document).on( 'click', '.btn_report', function(){
            customer_id = $(this).data('customer_id');
            status = $(this).data('status');
            // var _token = $('meta[name="csrf-token"]').attr('content');
            // alert(customer_id + " " + status);
        });
        $('.btn_deleted').click(function(){
            $.ajax({
                url: '{{ url('admin/user/active-unactive-user') }}',
                method: 'get',
                data: {
                    customer_id: customer_id,
                    status: status,
                },
                success: function(data) {
                   if(status == "1"){
                    message_toastr("success",
                            "Đã kích hoạt tài khoản thành công!");
                    }else{
                        message_toastr("success", "Đã vô hiệu hóa tài khoản thành công!");
                    }
                    load_all_user();
                    // count_delete();
                },
                error: function() {
                    alert("Bug Huhu :<<");
                }
            })
        })
    </script>
</body>
