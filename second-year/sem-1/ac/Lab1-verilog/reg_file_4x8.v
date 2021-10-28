module reg_file_4x8(
  input rst_b,clk,clr,e,
  input [1:0] wr_adr ,rd_adr,
  input [7:0] wr_data,
  output [7:0] rd_data);
  
  wire [3:0] w;
  wire [7:0] q0,q1,q2,q3;
  
  drec2x_4 d(
    .s(wr_adr),
    .e(e),
    .o(w));
    
  reg8b b1(
  .ld(w[0]),
  .clk(clk),
  .rst_b(rst_b),
  .clr(clr),
  .d(wr_data),
  .q(q0));
  
  reg8b b2(
  .ld(w[1]),
  .clk(clk),
  .rst_b(rst_b),
  .clr(clr),
  .d(wr_data),
  .q(q1));
  
  reg8b b3(
  .ld(w[2]),
  .clk(clk),
  .rst_b(rst_b),
  .clr(clr),
  .d(wr_data),
  .q(q2));
  
  reg8b b4(
  .ld(w[3]),
  .clk(clk),
  .rst_b(rst_b),
  .clr(clr),
  .d(wr_data),
  .q(q3));
  
  mux_2s_8b m(
  .s(rd_adr),
  .d0(q0),
  .d1(q1),
  .d2(q2),
  .d3(q3),
  .o(rd_data));
  
endmodule
