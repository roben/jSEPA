/*
 *  All rights reserved.
 */
package eu.rbecker.jsepa.directdebit;

import de.jost_net.OBanToo.SEPA.BIC;
import de.jost_net.OBanToo.SEPA.IBAN;
import de.jost_net.OBanToo.SEPA.SEPAException;
import de.jost_net.OBanToo.StringLatin.Zeichen;
import eu.rbecker.jsepa.sepa.SepaUtil;
import java.util.Date;

/**
 *
 * @author Robert Becker <robert at rbecker.eu>
 */
public class DirectDebitPayment {

    private float paymentSum;

    private String debitorIban;

    private String debitorBic;

    private String debitorName;

    private String reasonForPayment;

    private String mandateId;

    private Date mandateDate;

    private Date directDebitDueDate;

    private MandateType mandateType;

    public void validate() throws SepaValidationException {
        if (directDebitDueDate == null) {
            throw new SepaValidationException("Due date missing.");
        }
    }

    public float getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(float paymentSum) {
        this.paymentSum = paymentSum;
    }

    public String getDebitorIban() {
        return debitorIban;
    }

    public void setDebitorIban(String debitorIban) throws SepaValidationException {
        SepaUtil.validateIban(debitorIban);
        this.debitorIban = debitorIban;
    }

    public String getDebitorBic() {
        return debitorBic;
    }

    public void setDebitorBic(String debitorBic) throws SepaValidationException {
        SepaUtil.validateBic(debitorBic);
        this.debitorBic = debitorBic;
    }

    public String getDebitorName() {
        return Zeichen.convert(debitorName);
    }

    public void setDebitorName(String debitorName) {
        this.debitorName = debitorName;
    }

    public String getReasonForPayment() {
        return Zeichen.convert(reasonForPayment);
    }

    public void setReasonForPayment(String reasonForPayment) {
        this.reasonForPayment = reasonForPayment;
    }

    public String getMandateId() {
        return mandateId;
    }

    public void setMandateId(String mandateId) {
        this.mandateId = mandateId;
    }

    public Date getMandateDate() {
        return mandateDate;
    }

    public void setMandateDate(Date mandateDate) {
        this.mandateDate = mandateDate;
    }

    public Date getDirectDebitDueDate() {
        return directDebitDueDate;
    }

    public void setDirectDebitDueDate(Date directDebitDueDate) {
        this.directDebitDueDate = directDebitDueDate;
    }

    public MandateType getMandateType() {
        return mandateType;
    }

    public void setMandateType(MandateType mandateType) {
        this.mandateType = mandateType;
    }

}
