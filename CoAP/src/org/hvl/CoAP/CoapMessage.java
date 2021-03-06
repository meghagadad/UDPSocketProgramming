package org.hvl.CoAP;




public interface CoapMessage {
	
	public static final int RESPONSE_TIMEOUT_MS = 2000;
    public static final double RESPONSE_RANDOM_FACTOR = 1.5;
    public static final int MAX_RETRANSMIT = 4;
    /* TODO: what is the right value? */
    public static final int ACK_RST_RETRANS_TIMEOUT_MS = 120000;
    
    /* returns the value of the internal message code
     * in case of an error this function returns -1 */
    public int getMessageCodeValue();

    public int getID();

    public void setID(int msgID);
    
    public byte[] serialize();

    public void incRetransCounterAndTimeout();

    //public CoapPacketType getPacketType();

    public byte[] getPayloadSize();

    public void setPayload(byte[] payload);

    public void setPayload(char[] payload);

    public void setPayload(String payload);

    public int getPayloadLength();
    
    public void setContentType(MediaTypeRegistery mediaType);
    
    public MediaTypeRegistery getContentType();
    
    public byte[] getToken();
    
//    public URI getRequestUri();
//
//    public void setRequestUri(URI uri); //TODO:allow this method only for Clients, Define Token Type
    
    //CoapBlockOption getBlock1();
    
    //void setBlock1(CoapBlockOption blockOption);
    
    //CoapBlockOption getBlock2();
    
    //void setBlock2(CoapBlockOption blockOption);

    //public Integer getObserveOption();

    //public void setObserveOption(int sequenceNumber);

   // public void removeOption(CoapHeaderOptionType optionType); //TODO: could this compromise the internal state?
    
    public String toString();

    //public CoapChannel getChannel();

    //public void setChannel(CoapChannel channel);

    public int getTimeout();

    public boolean maxRetransReached();

    public boolean isReliable();
    
    public boolean isRequest();
    
    public boolean isResponse();
    
    public boolean isEmpty();

    /* unique by remote address, remote port, local port and message id */
    public int hashCode();
    public boolean equals(Object obj);

}
