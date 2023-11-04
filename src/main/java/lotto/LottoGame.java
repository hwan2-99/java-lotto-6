package lotto;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningNumbers;
import lotto.service.MessageService;
public class LottoGame {
    private final MessageService messageService = new MessageService();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers();
    public void LottoPlay() {
        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        messageService.outputPurchaseAmount(purchaseAmount);
        List<Lotto> purchaseNumbers = lottoPurchase.purchaseLottoNumbers(purchaseAmount);
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
        messageService.outputResultMessage();
        LottoResult lottoResult = new LottoResult(winningNumbersInfo);
        lottoResult.getLottoStatus(purchaseNumbers);
    }
}
