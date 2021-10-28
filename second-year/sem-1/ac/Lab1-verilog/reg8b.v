module reg8b(
  input ld,clk,rst_b,clr
  input [7:0] d;
  output reg [7:0] q);
  
  always @(posedge clk or negedge rst_b or posedge clr) begin
  
    if(rst_b==1 && clr==0 && ld==1)
      q<=d;
    else
      q<=0;
    end 
  
  end
  
endmodule
