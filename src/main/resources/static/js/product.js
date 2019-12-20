var index = 1;

var list = [];

/*
 * var color = $("#color").val(); var memory = $("#memory").val(); var price =
 * $("#price").val(); var size = $("#size").val(); var quantity =
 * $("#quantity").val();
 */

$(document)
		.ready(
				function() {

					$('input').click(function(event) {
						$(this).next('small.error-message').hide();
					});

					console.log("hello.1");

					if (jQuery.isEmptyObject(list)) {
						// create
						console.log("create.............");

					} else if (list.length > 0) {

						console.log("in if else.....");
						console.log(list.length);

						var tempList = [];
						list.forEach(function(item) {
							tempList.push(item);
						});

						for (let i = 0; i < tempList.length; i++) {

							console.log(".." + tempList[i].color + ".."
									+ tempList[i].memory + ".."
									+ tempList[i].price + ".."
									+ tempList[i].size + ".."
									+ tempList[i].quantity);
						}

						document.getElementById('excelManyDtoList0.color').value = tempList[0].color;
						document.getElementById('excelManyDtoList0.memory').value = tempList[0].memory;
						document.getElementById('excelManyDtoList0.price').value = tempList[0].price;
						document.getElementById('excelManyDtoList0.size').value = tempList[0].size;
						document.getElementById('excelManyDtoList0.quantity').value = tempList[0].quantity;

						if (list.length > 1) {
							for (let i = 1; i < list.length; i++) {

								console
										.log("list is greater than 1..............");

								$(".element:last").after(
										"<div class='element' id='div_" + i
												+ "'></div>");

								$("#div_" + i)
										.append(
												"<div class='row' id='txt_"
														+ i
														+ "'>"
														+ "<div class='form-group col-md-2'>"
														+ "<input class='form-control' id='excelManyDtoList"
														+ i
														+ ".color' name='excelManyDtoList["
														+ i
														+ "].color' type='text'  placeholder='Color' value='"
														+ tempList[i].color
														+ "'> "
														+ "</div>"
														+ "<div class='form-group col-md-2'>"
														+ "<input class='form-control' id='excelManyDtoList"
														+ i
														+ ".memory' name='excelManyDtoList["
														+ i
														+ "].memory' type='text' placeholder='Memory' value='"
														+ tempList[i].memory
														+ "'> "
														+ "</div>"
														+ "<div class='form-group col-md-2'>"
														+ "<input class='form-control' id='excelManyDtoList"
														+ i
														+ ".price' name='excelManyDtoList["
														+ i
														+ "].price' type='text' placeholder='Price' value='"
														+ tempList[i].price
														+ "'> "
														+ "</div>"
														+ "<div class='form-group col-md-2'>"
														+ "<input class='form-control' id='excelManyDtoList"
														+ i
														+ ".size' name='excelManyDtoList["
														+ i
														+ "].size' type='text'  placeholder='Size' value='"
														+ tempList[i].size
														+ "'> "
														+ "</div>"
														+ "<div class='form-group col-md-2'>"
														+ "<input class='form-control' id='excelManyDtoList"
														+ i
														+ ".quantity' name='excelManyDtoList["
														+ i
														+ "].quantity' type='number'  placeholder='Quantity' value='"
														+ tempList[i].quantity
														+ "'> "
														+ "</div>"

														+ "<div class='form-group col-md-2 field_wrapper' style='text-align: center;'> <span id='remove_"
														+ i
														+ "' class='remove btn btn-danger btn-block' >Remove</span></div>");

							}
						}
					}

					$(".add")
							.click(
									function() {

										// Finding total number of elements
										// added
										var total_element = $(".element").length;

										// last <div> with element class id
										var lastid = $(".element:last").attr(
												"id");
										var split_id = lastid.split("_");
										var nextindex = Number(split_id[1]) + 1;

										var max = 15;
										// Check total number elements
										if (total_element < max) {
											// Adding new div myContainer after
											// last occurance of
											// element class
											$(".element:last").after(
													"<div class='element' id='div_"
															+ nextindex
															+ "'></div>");

											// Adding element to <div>
											$("#div_" + nextindex)
													.append(
															"<div class='row' id='txt_"
																	+ nextindex
																	+ "'>"
																	+ "<div class='form-group col-md-2'>"
																	+ "<input required class='form-control' id='excelManyDtoList"
																	+ nextindex
																	+ ".color' name='excelManyDtoList["
																	+ nextindex
																	+ "].color' type='text'  placeholder='Color' value=''> "
																	+ "</div>"
																	+ "<div class='form-group col-md-2'>"
																	+ "<input required class='form-control' id='excelManyDtoList"
																	+ nextindex
																	+ ".memory' name='excelManyDtoList["
																	+ nextindex
																	+ "].memory' type='text' placeholder='Memory' value=''> "
																	+ "</div>"
																	+ "<div class='form-group col-md-2'>"
																	+ "<input required class='form-control' id='excelManyDtoList"
																	+ nextindex
																	+ ".price' name='excelManyDtoList["
																	+ nextindex
																	+ "].price' type='text' placeholder='Price' value=''> "
																	+ "</div>"
																	+ "<div class='form-group col-md-2'>"
																	+ "<input required class='form-control' id='excelManyDtoList"
																	+ nextindex
																	+ ".size' name='excelManyDtoList["
																	+ nextindex
																	+ "].size' type='text'  placeholder='Size' value=''> "
																	+ "</div>"
																	+ "<div class='form-group col-md-2'>"
																	+ "<input required class='form-control' id='excelManyDtoList"
																	+ nextindex
																	+ ".quantity' name='excelManyDtoList["
																	+ nextindex
																	+ "].quantity' type='number'  placeholder='Quantity' value=''> "
																	+ "</div>"

																	+ "<div class='form-group col-md-2 field_wrapper' style='text-align: center;'> <span id='remove_"
																	+ nextindex
																	+ "' class='remove btn btn-danger btn-block' >Remove</span></div>");

										}

									});

					// Remove element
					$('.myContainer').on('click', '.remove', function() {

						var id = this.id;
						var split_id = id.split("_");
						var deleteindex = split_id[1];

						// Remove <div> with id
						$("#div_" + deleteindex).remove();

					});

				});
