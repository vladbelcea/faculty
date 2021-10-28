module reg_file_4x8_tb(
  output reg rst_b,clk,clr,e,
  output reg [1:0] wr_adr ,rd_adr,
  output reg [7:0] wr_data,
  output [7:0] rd_data );
  
  
 reg_file_4x8_tb DUT (
  .rst(rst),.clk(clk),.clr(clr),.e(e),
  .wr_adr(wr_adr),.rd_adr(rd_adr),
  .wr(wr_data),
  .rd_data(rd_data));
  
  initial begin
    
    clk=0;
    
    forever 
      #20 clk=~clk;
  end
  
  initial begin
    
    rst_b=0;
    
    #20 rst_b=~rst_b;
       
  end
  
  initial begin
  
  clr=1;
  #20 clr=~clr;
  
end

initial begin
  e=0;
  
  #20 e=~e;
end

integer i;

initial begin

  {wr_adr,rd_adr,wr_data}= 12'd0;
  
  for(i=0;i<2**12;i=i+1)
    #50 {wr_adr,rd_adr,wr_data} = i[11:0];
    
  end
  
end

endmodule



    
  