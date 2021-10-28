module dec2x_4(
  input [1:0] s,
  input e,
  output reg [3:0] o);
  
  always @(*) begin
   
   if(e) 
      if(s==2'b00)
        o=4'b0001;
      end
      if(s==2'b01)
        o=4'b0010;
      end
      if(s==2'b10)
        o=4'b0100;
      end
      if(s==2'b11)
        o=4'b1000;
      end
  end
  
endmodule  
